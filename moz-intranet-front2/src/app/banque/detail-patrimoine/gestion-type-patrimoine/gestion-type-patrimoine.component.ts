import { Component, OnInit } from '@angular/core';

interface typePatrimoine {
  name: string;
  id: number;
}

const TYPES_PATRIMOINE: typePatrimoine[] = [
  {
    name: 'PEL',
    id : 1
  },
  {
    name: 'Livret A',
    id : 2
  },
  {
    name: 'BNP',
    id : 3
  },
  {
    name: 'SG',
    id : 4
  },
  {
    name: 'Test',
    id : 5
  }
];

@Component({
  selector: 'app-gestion-type-patrimoine',
  templateUrl: './gestion-type-patrimoine.component.html',
  styleUrls: ['./gestion-type-patrimoine.component.css']
})
export class GestionTypePatrimoineComponent implements OnInit {

  typesPatrimoine: typePatrimoine[] = TYPES_PATRIMOINE;

  constructor() { }

  ngOnInit() {
  }

}
