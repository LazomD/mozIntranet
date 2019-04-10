import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Configuration} from "../configuration/app.constants";
import {Observable} from "rxjs";

@Injectable()
export class BanqueService {

  constructor(private http: HttpClient, private configuration: Configuration) {
  }

  public getDataPatrimoineTotal():Observable<any> {
    return this.http.get(this.configuration.serverBack + "banque/patrimoine/1");
  }
}
