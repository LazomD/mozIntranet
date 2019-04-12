import { Component, OnInit, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import {ROUTES} from "../../shared/sidebar/menu-items";
declare var $: any;

@Component({
  selector: 'app-full-layout',
  templateUrl: './full.component.html',
  styleUrls: ['./full.component.scss']
})
export class FullComponent implements OnInit {

  constructor(public router: Router) {}

  public isCollapsed = false;

  public innerWidth: any;
  public defaultSidebar: any;
  public showMobileMenu = false;
  public expandLogo = false;
  public ssmenu;

  options = {
    sidebartype: 'full',
  };

  Logo() {
    this.expandLogo = !this.expandLogo;
  }

  ngOnInit() {
    if (this.router.url === '/') {
      this.router.navigate(['/dashboard/dashboard1']);
    }
    this.defaultSidebar = this.options.sidebartype;
    this.handleSidebar();
    this.ssmenu = ROUTES[0].submenu;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.handleSidebar();
  }

  handleSidebar() {
    this.innerWidth = window.innerWidth;
    switch (this.defaultSidebar) {
      case 'full':
        if (this.innerWidth < 1170) {
          this.options.sidebartype = 'mini-sidebar';
        } else {
          this.options.sidebartype = this.defaultSidebar;
        }
        break;
      default:
    }
  }

  majSsMenu(ssmenu: any[]) {
    this.ssmenu = ssmenu;
  }
}
