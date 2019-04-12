import { RouteInfo } from './sidebar.metadata';

export const ROUTES: RouteInfo[] = [
  {
    path: '/banque/patrimoine',
    title: 'Banque',
    icon: 'mdi mdi-cash-100',
    class: '',
    extralink: false,
    submenu: [{
      path: '/banque/patrimoine',
      title: 'Patrimoine',
      icon: 'mdi mdi-football',
      class: '',
      extralink: false,
      submenu: []
    },
      {
        path: '/banque/detailpatrimoine',
        title: 'Détail patrimoine',
        icon: 'mdi mdi-football',
        class: '',
        extralink: false,
        submenu: []
      }]
  },
  {
    path: '/sport',
    title: 'Sport',
    icon: 'mdi mdi-football',
    class: '',
    extralink: false,
    submenu: []
  }
];
