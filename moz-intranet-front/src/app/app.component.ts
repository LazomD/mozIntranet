import { Component } from '@angular/core';
import {DataService} from "./services/data.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'moz-intranet-front';
  data:string = "depart";
  shouldRun = [/(^|\.)plnkr\.co$/, /(^|\.)stackblitz\.io$/].some(h => h.test(window.location.host));


  constructor(private dataService: DataService) {
  }

  public chargerDonnee(): void {
    this.dataService.getData().subscribe(
      (reponse: any) => this.data = reponse['valeur']
    );
  }
}
