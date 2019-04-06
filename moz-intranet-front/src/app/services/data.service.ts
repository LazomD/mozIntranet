import {Injectable} from "@angular/core";
import {Configuration} from "../configuration/app.constants";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class DataService {

  constructor(private http: HttpClient, private configuration: Configuration) {
  }

  public getData():Observable<any> {
    return this.http.get(this.configuration.serverBack);
  }
}
