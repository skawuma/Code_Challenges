import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../services/document.service';
import { Document } from '../_model/document.model';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-new-document',
  templateUrl: './add-new-document.component.html',
  styleUrls: ['./add-new-document.component.css']
})
export class AddNewDocumentComponent implements OnInit {
  isNewDocument =true;
  submitted = false;
  registerSucess=false;
document:Document={
  sku: '',
  author: '',
  title: '',
  price: 0
}
  myform!: FormGroup;

  constructor(private documentService:DocumentService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

  }

  

public addDocument(documentForm: NgForm ){
    const formData = new FormData();
  this.documentService.addDocument(formData ).subscribe(
    (response:Document)=>{
      console.log(response);
      // documentForm.reset();   
    },
    (error:HttpErrorResponse)=>{
      console.log(error);
    }
  );

}



newBooking(): void {
  this.submitted = false;
  this.document;
}

save() {
  this.documentService.add(this.document)
  .subscribe(data => console.log(data),
  error => console.log(error));
  
  
  //this.gotoList();
}

onSubmit() {
  
    this.save();
    console.log("Form Submitted!");
  
  
  
  
  this.submitted = true;
}







  }


