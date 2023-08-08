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
sku:any
  showTable =true;
  submitted=true;
  documentDetails: Document[]=[];
  // document:Document={
  //   sku: '',
  //   author: '',
  //   title: '',
  //   price: 0
  // }
  displayedColumns: string[] = ['SKU', 'Author','Title','Price']
  show:boolean=false;

  constructor( private documentService:DocumentService,
    private router:Router
    ) { }

  ngOnInit(): void {
   
  }


searchDocument(sku:any):any{
  
  console.log(sku);
  this.documentService.getById(sku)
  .subscribe(
    (resp:any) =>{
//resp.forEach((p)=> this.documentDetails.push(p));
  this.documentDetails= new Array(resp);

  console.log(this.documentDetails);
  console.log(resp);

},(error:HttpErrorResponse)=>{
  console.log(console.error);
} 

);
}
idValid:boolean=false;
validateId(){
    if(this.sku>999){
        this.idValid=true;
    }
    else if(this.sku<1){
        this.idValid=true;
    }else{
        this.idValid=false;
    }
}










}
