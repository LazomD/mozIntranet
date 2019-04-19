import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HighchartsChartModule } from 'highcharts-angular';

import { BanqueComponent } from './banque.component';
import {DataService} from "../services/data.service";
import {Configuration} from "../configuration/app.constants";
import {BanqueService} from "../services/banque.service";
import { DetailPatrimoineComponent } from './detail-patrimoine/detail-patrimoine.component';
import { GestionTypePatrimoineComponent } from './detail-patrimoine/gestion-type-patrimoine/gestion-type-patrimoine.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

const routes: Routes = [
  { path: 'banque', redirectTo: '/banque/patrimoine', pathMatch: 'full' },
  {
    path: 'patrimoine',
    data: {
      title: 'Patrimoine',
      urls: [
        { title: 'Dashboard', url: '/dashboard' },
        { title: 'Patrimoine' }
      ]
    },
    component: BanqueComponent
  },
  {
    path: 'detailpatrimoine',
    data: {
      title: 'Détail patrimoine',
      urls: [
        { title: 'Dashboard', url: '/dashboard' },
        { title: 'Détail patrimoine' }
      ]
    },
    component: DetailPatrimoineComponent
  },
  {
    path: 'gestiontypepatrimoine',
    data: {
      title: 'Gestion du type de patrimoine',
      urls: [
        { title: 'Dashboard', url: '/dashboard' },
        { title: 'Détail patrimoine' , url: 'detailpatrimoine'},
        { title: 'Gestion type patrimoine' }
      ]
    },
    component: GestionTypePatrimoineComponent
  }
];

@NgModule({
  imports: [FormsModule, NgbModule, CommonModule, HighchartsChartModule, RouterModule.forChild(routes), ReactiveFormsModule],
  declarations: [BanqueComponent, DetailPatrimoineComponent, GestionTypePatrimoineComponent],
  providers: [DataService, BanqueService, Configuration]
})
export class BanqueModule {}
