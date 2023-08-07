import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Document } from '../_model/document.model';
import { Observable } from 'rxjs';

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

  searchDocumentBySku(searchSku: any) {
    return this.httpClient.get(this.url + "/search/"+ searchSku);
  }

  addDocument(document:Document): Observable<Object> {
    return this.httpClient.post(`${this.url}/addDoc`, document);
  }


}
