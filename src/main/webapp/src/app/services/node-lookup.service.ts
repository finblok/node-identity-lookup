import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {API_URL} from "./API_URL";
import {map} from "rxjs/internal/operators";
import {NodeIdentity} from "../model/NodeIdentity";

@Injectable()
export class NodeLookupService {

  url = API_URL.url;

  headers = new HttpHeaders({
    'Authorization': 'Bearer ' + localStorage.getItem('auth_token'),
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get(this.url + "/all",
      {headers: this.headers})
      .pipe(map((res) => res as NodeIdentity[]));
  }

  updateNickname(x500Name : string, newName : string) {
    return this.http.get(this.url + "/node/nickname/new/" + x500Name + "/" + newName,
      {headers: this.headers});
  }

}
