import { Component, OnInit } from '@angular/core';
import { Document } from '../_model/document.model';
import { DocumentService } from '../services/document.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { map } from 'rxjs';

@Component({
  selector: 'app-show-document-details',
  templateUrl: './show-document-details.component.html',
  styleUrls: ['./show-document-details.component.css']
})
export class ShowDocumentDetailsComponent implements OnInit {

  showTable =false;
  showLoadButton = false;
  documentDetails: Document[]=[];
  displayedColumns: string[] = ['SKU', 'Author','Title','Price']


  constructor( private documentService:DocumentService,
    private router:Router
    ) { }

  ngOnInit(): void {
  }

public getDocumentById(sku: any){

  this.showTable= false;
  this.documentService.getById(sku)
 
  .subscribe(
    (resp:any) =>{

      resp.forEach((p: Document)=> this.documentDetails.push(p));
      console.log(this.documentDetails);
      this.showTable =true;

    },(error:HttpErrorResponse)=>{
      console.log(console.error);
    } 
    

  );


}

public searchBykeyword(searchkeyword:any){
  console .log (searchkeyword);

  this.documentDetails =[];
this.getDocumentById(searchkeyword);

}


}
