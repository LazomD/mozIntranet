import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {BanqueService} from "../services/banque.service";

@Injectable()
export class BanqueResolver implements Resolve<any> {

  constructor(private banqueService: BanqueService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> | Promise<any> | any {
    return this.banqueService.getDataPatrimoineTotal();
  }
}
