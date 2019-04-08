import {Component, AfterViewInit, OnInit} from '@angular/core';
import {DataService} from "../services/data.service";
import * as Highcharts from 'highcharts';

@Component({
  templateUrl: './starter.component.html'
})
export class StarterComponent implements AfterViewInit, OnInit {
  values = [
    [1246406400000, 21.5],
    [1246492800000, 22.1],
    [1246579200000, 23],
    [1246665600000, 23.8],
    [1246752000000, 21.4],
    [1246838400000, 21.3],
    [1246924800000, 18.3],
    [1247011200000, 15.4],
    [1247097600000, 16.4],
    [1247184000000, 17.7],
    [1247270400000, 17.5],
    [1247356800000, 17.6],
    [1247443200000, 17.7],
    [1247529600000, 16.8],
    [1247616000000, 17.7],
    [1247702400000, 16.3],
    [1247788800000, 17.8],
    [1247875200000, 18.1],
    [1247961600000, 17.2],
    [1248048000000, 14.4],
    [1248134400000, 13.7],
    [1248220800000, 15.7],
    [1248307200000, 14.6],
    [1248393600000, 15.3],
    [1248480000000, 15.3],
    [1248566400000, 15.8],
    [1248652800000, 15.2],
    [1248739200000, 14.8],
    [1248825600000, 14.4],
    [1248912000000, 15],
    [1248998400000, 13.6]
  ];

  Highcharts = Highcharts;
  chartOptions = {
    chart: {
      type: 'area'
    },

    title: {
      text: 'Patrimoine'
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
      data: this.values
    }]
  };

  subtitle: string;
  constructor(private dataService: DataService) {
    this.subtitle = 'This is some text within a card block.';
  }

  ngOnInit(): void {
    this.chargerDonnee();
  }

  ngAfterViewInit() {}

  public chargerDonnee(): void {
    this.dataService.getData().subscribe(
      (reponse: any) => this.subtitle = reponse['valeur']
    );
  }
}
