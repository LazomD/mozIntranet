import {Component, AfterViewInit, OnInit, Output, EventEmitter} from '@angular/core';
import { ROUTES } from './menu-items';
import { RouteInfo } from './sidebar.metadata';
import { Router, ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
declare var $: any;

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {

  @Output() ssmenu = new EventEmitter<any[]>();
  showMenu = 'Banque';
  public sidebarnavItems: any[];
  // this is for the open close
  addExpandClass(element: any) {
    console.log(element.submenu);
    this.ssmenu.emit(element.submenu);
    if (element.title === this.showMenu) {
      this.showMenu = '0';
    } else {
      this.showMenu = element.title;
    }
  }

  constructor(
    private modalService: NgbModal,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  // End open close
  ngOnInit() {
    this.sidebarnavItems = ROUTES.filter(sidebarnavItem => sidebarnavItem);
  }
}
