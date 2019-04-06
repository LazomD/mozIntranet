import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {DataService} from "./services/data.service";
import {HttpClientModule} from "@angular/common/http";
import {Configuration} from "./configuration/app.constants";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [DataService, Configuration],
  bootstrap: [AppComponent]
})
export class AppModule { }
