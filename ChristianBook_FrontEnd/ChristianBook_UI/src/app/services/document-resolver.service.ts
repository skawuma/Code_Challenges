import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Document } from '../_model/document.model';
import { Observable, of } from 'rxjs';
import { DocumentService } from './document.service';

@Injectable({
  providedIn: 'root'
})
export class DocumentResolverService  implements Resolve<Document>{

  constructor(private documentService: DocumentService) { }
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):  Observable<Document>  {
  const id =route.paramMap.get("sku");
  if(id){
    //then we to fetch details from backend
return this.documentService.getById(id)
  }else{
    //Return Empty product Observable
    return of(this.getDocumentDetails());
  }

  }

  getDocumentDetails(){
    return{
    sku: '',
    author: '',
    title: '',
    price: 0
    };
  }
}
