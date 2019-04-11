import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccueilComponent } from './accueil/accueil.component';
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Sport',
      urls: [
        { title: 'Dashboard', url: '/dashboard' },
        { title: 'Sport' }
      ]
    },
    component: AccueilComponent
  }
];

@NgModule({
  declarations: [AccueilComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class SportModule { }
