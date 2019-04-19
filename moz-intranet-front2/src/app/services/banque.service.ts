import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Configuration} from "../configuration/app.constants";
import {Observable} from "rxjs";
import {TypePatrimoine} from "../banque/detail-patrimoine/gestion-type-patrimoine/TypePatrimoine";

@Injectable()
export class BanqueService {

  public httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient, private configuration: Configuration) {
  }

  public getDataPatrimoineTotal():Observable<any> {
    return this.http.get(this.configuration.serverBack + "banque/patrimoine/1");
  }

  public saveTypePatrimoine(typePatrimoine: TypePatrimoine):Observable<TypePatrimoine> {
    return this.http.post<TypePatrimoine>(this.configuration.serverBack + "banque/patrimoine/saveType", JSON.stringify(typePatrimoine), this.httpOptions);
  }

  public getAllTypePatrimoine():Observable<TypePatrimoine[]>{
    return this.http.get<TypePatrimoine[]>(this.configuration.serverBack + "banque/patrimoine/allType");
  }
}
