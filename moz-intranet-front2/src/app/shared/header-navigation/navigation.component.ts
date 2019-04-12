import {Component, AfterViewInit, Input} from '@angular/core';
import {
  NgbModal
} from '@ng-bootstrap/ng-bootstrap';
import {Router} from "@angular/router";
declare var $: any;

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html'
})
export class NavigationComponent {

  @Input() ssmenu: any[];

  constructor(private router: Router) {}

}
