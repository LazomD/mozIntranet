import {Component, AfterViewInit, OnInit} from '@angular/core';
import {DataService} from "../services/data.service";
import * as Highcharts from 'highcharts';
import {BanqueService} from "../services/banque.service";

@Component({
  templateUrl: './banque.component.html'
})
export class BanqueComponent implements AfterViewInit, OnInit {

  donnees=null;
  Highcharts;
  updateFlag = true;
  chartOptions = {
    chart: {
      type: 'area'
    },

    title: {
      text: ''
    },

    xAxis: {
      type: 'datetime',
      dateTimeLabelFormats: {
        day: '%d %b %Y'    //ex- 01 Jan 2016
      }
    },

    yAxis: {
      title: {
        text: 'Montant en €'
      }
    },

    tooltip: {
      crosshairs: true,
      shared: true,
      valueSuffix: ' €'
    },

    legend: {
    },

    series: [{
      name: 'Montant',
      data: this.donnees
    }]
  };

  constructor(private dataService: DataService, private banqueService: BanqueService) {
  }

  ngOnInit(): void {
    this.chargerDonnee();
  }

  ngAfterViewInit() {}

  public chargerDonnee(): void {

    this.banqueService.getDataPatrimoineTotal().subscribe(
      (reponse) => {
        this.donnees = reponse;
        this.chartOptions.series[0].data = this.donnees;
        this.Highcharts = Highcharts;
        this.updateFlag = true;
        console.log(reponse);
      }
  )}
}
