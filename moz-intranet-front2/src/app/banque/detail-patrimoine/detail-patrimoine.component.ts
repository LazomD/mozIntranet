import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {NgbCalendar} from "@ng-bootstrap/ng-bootstrap";
import {BanqueService} from "../../services/banque.service";

interface Country {
  name: string;
  flag: string;
  area: number;
  population: number;
}

const COUNTRIES: Country[] = [
  {
    name: 'Russia',
    flag: 'f/f3/Flag_of_Russia.svg',
    area: 17075200,
    population: 146989754
  },
  {
    name: 'Canada',
    flag: 'c/cf/Flag_of_Canada.svg',
    area: 9976140,
    population: 36624199
  },
  {
    name: 'United States',
    flag: 'a/a4/Flag_of_the_United_States.svg',
    area: 9629091,
    population: 324459463
  },
  {
    name: 'China',
    flag: 'f/fa/Flag_of_the_People%27s_Republic_of_China.svg',
    area: 9596960,
    population: 1409517397
  }
];

@Component({
  selector: 'app-detail-patrimoine',
  templateUrl: './detail-patrimoine.component.html',
  styleUrls: ['./detail-patrimoine.component.css']
})
export class DetailPatrimoineComponent implements OnInit {

  countries = COUNTRIES;
  formGroup: FormGroup;
  items: FormArray;

  constructor(private formBuilder: FormBuilder, private calendar: NgbCalendar, private banqueService: BanqueService) { }

  ngOnInit() {
    let date = new Date();
    this.formGroup = this.formBuilder.group({
      date: new FormControl(this.calendar.getToday(), [Validators.required]),
      time: new FormControl({hour: date.getHours(), minute: date.getMinutes(), second: date.getSeconds()}, [Validators.required]),
      items: this.formBuilder.array([])
    });

    this.items = this.formGroup.get('items') as FormArray;

    this.banqueService.getAllTypePatrimoine().subscribe(
      tPtab => {
        for (let typePatrimoine of tPtab) {
          this.items.push(this.formBuilder.group({
            id: typePatrimoine.id,
            name: typePatrimoine.name,
            valeur: []
          }));
        }
      }
    );
  }

}
