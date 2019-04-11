import {Component, AfterViewInit, OnInit} from '@angular/core';
import * as Highcharts from 'highcharts';
import {ActivatedRoute, Data, NavigationEnd, Router} from "@angular/router";
import {filter} from "rxjs/operators";

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

  constructor(private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.data.subscribe((data: Data) => {
        this.chartOptions.series[0].data = data["donnees"];
        this.updateFlag = true;
        console.log(data["donnees"]);
      }
    );

    this.router.events
      .pipe(
        filter(event => event instanceof NavigationEnd)
      )
      .subscribe((event: NavigationEnd) => {
        console.log('Got the Event URL as ', event.url);
        if(event.urlAfterRedirects.includes('project')) {
          console.log('This was redirected to the Project Component');
        }
      });
  }

  ngAfterViewInit() {}
}
