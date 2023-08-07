import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  url =environment.apiUrl +"/api/v1/document";
  constructor(private httpClient: HttpClient) { }
  public add(data: any) {
    return this.httpClient.post(this.url +
      "/add", data, {
      headers: new HttpHeaders().set('Content-Type', "application/json")
    })
  }

 public  getById(sku: any) {
    return this.httpClient.get(this.url + "/getById/" + sku);
  }


}
