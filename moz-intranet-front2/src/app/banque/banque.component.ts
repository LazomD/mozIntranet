import {Component, AfterViewInit, OnInit} from '@angular/core';
import {DataService} from "../services/data.service";
import * as Highcharts from 'highcharts';
import {BanqueService} from "../services/banque.service";
import {Options} from "highcharts";

@Component({
  templateUrl: './banque.component.html'
})
export class BanqueComponent implements AfterViewInit, OnInit {

  Highcharts = Highcharts;
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
      data: null
    }]
  };

  constructor(private dataService: DataService, private banqueService: BanqueService) {
  }

  ngOnInit(): void {
    setTimeout(()=>this.chargerDonnee(),1000);
  }

  ngAfterViewInit() {}

  public chargerDonnee(): void {

    this.banqueService.getDataPatrimoineTotal().subscribe(
      (reponse) => {
        this.chartOptions.series[0].data = reponse;
        this.updateFlag = true;
        console.log(reponse);
      }
  )
  }
}
