import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FullComponent } from './layouts/full/full.component';

export const Approutes: Routes = [
  {
    path: '',
    component: FullComponent,
    children: [
      { path: '', redirectTo: '/banque/patrimoine', pathMatch: 'full' },
      {
        path: 'banque',
        loadChildren: './banque/banque.module#BanqueModule'
      },
      {
        path: 'sport',
        loadChildren: './sport/sport.module#SportModule'
      }
      ]
  },
  {
    path: '**',
    redirectTo: '/banque/patrimoine'
  }
];
