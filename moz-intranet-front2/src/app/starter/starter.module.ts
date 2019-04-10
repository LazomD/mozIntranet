import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HighchartsChartModule } from 'highcharts-angular';

import { StarterComponent } from './starter.component';
import {DataService} from "../services/data.service";
import {Configuration} from "../configuration/app.constants";
import {BanqueService} from "../services/banque.service";

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
    component: StarterComponent
  }
];

@NgModule({
  imports: [FormsModule, CommonModule, HighchartsChartModule, RouterModule.forChild(routes)],
  declarations: [StarterComponent],
  providers: [DataService, BanqueService, Configuration]
})
export class StarterModule {}
