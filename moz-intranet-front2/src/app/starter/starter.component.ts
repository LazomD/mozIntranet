import {Component, AfterViewInit, OnInit} from '@angular/core';
import {DataService} from "../services/data.service";
@Component({
  templateUrl: './starter.component.html'
})
export class StarterComponent implements AfterViewInit, OnInit {
  subtitle: string;
  constructor(private dataService: DataService) {
    this.subtitle = 'This is some text within a card block.';
  }

  ngOnInit(): void {
    this.chargerDonnee();
  }

  ngAfterViewInit() {}

  public chargerDonnee(): void {
    this.dataService.getData().subscribe(
      (reponse: any) => this.subtitle = reponse['valeur']
    );
  }
}
