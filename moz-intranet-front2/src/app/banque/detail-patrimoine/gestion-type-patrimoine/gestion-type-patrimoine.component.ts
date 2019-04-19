import { Component, OnInit } from '@angular/core';
import {BanqueService} from "../../../services/banque.service";
import {TypePatrimoine} from "./TypePatrimoine";

@Component({
  selector: 'app-gestion-type-patrimoine',
  templateUrl: './gestion-type-patrimoine.component.html',
  styleUrls: ['./gestion-type-patrimoine.component.css']
})
export class GestionTypePatrimoineComponent implements OnInit {

  typesPatrimoine: TypePatrimoine[] = [];

  model = {
    name:''
  };

  constructor(private banqueService: BanqueService) { }

  ngOnInit() {
    this.banqueService.getAllTypePatrimoine().subscribe(
      tPtab => {
        for (let typePatrimoine of tPtab) {
          this.typesPatrimoine.push(typePatrimoine);
        }
      }
    );
  }

  onSubmit() {
    let newTypePatrimoine: TypePatrimoine = new TypePatrimoine(undefined, this.model.name);
    this.model.name = "";
    this.banqueService.saveTypePatrimoine(newTypePatrimoine).subscribe(
      tP => {
        this.typesPatrimoine.push(new TypePatrimoine(tP.id, tP.name));
      }
    );
  }
}
