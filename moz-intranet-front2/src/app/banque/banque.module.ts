import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HighchartsChartModule } from 'highcharts-angular';

import { BanqueComponent } from './banque.component';
import {DataService} from "../services/data.service";
import {Configuration} from "../configuration/app.constants";
import {BanqueService} from "../services/banque.service";
import {BanqueResolver} from "./banque.resolver";

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Patrimoine',
      urls: [
        { title: 'Dashboard', url: '/dashboard' },
        { title: 'Patrimoine' }
      ]
    },
    component: BanqueComponent,
    resolve: {donnees: BanqueResolver}
  }
];

@NgModule({
  imports: [FormsModule, CommonModule, HighchartsChartModule, RouterModule.forChild(routes)],
  declarations: [BanqueComponent],
  providers: [DataService, BanqueService, Configuration, BanqueResolver]
})
export class BanqueModule {}
