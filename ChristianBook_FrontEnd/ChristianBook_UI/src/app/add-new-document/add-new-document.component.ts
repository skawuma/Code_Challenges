import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../services/document.service';
import { Document } from '../_model/document.model';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-new-document',
  templateUrl: './add-new-document.component.html',
  styleUrls: ['./add-new-document.component.css']
})
export class AddNewDocumentComponent implements OnInit {
  isNewDocument =true;
  submitted = false;

document:Document={
  sku: '',
  author: '',
  title: '',
  price: 0
}

  constructor(private documentService:DocumentService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
this.document=this.activatedRoute.snapshot.data['document']
if ( this.document && this.document.sku){
  this.isNewDocument =false;
}
  }

public addDocument(documentForm: NgForm ){
  const documentFormData = this.preparedocumentData(this.document);
  this.documentService.add(documentFormData).subscribe(
    (response)=>{
      documentForm.reset();   
    },
    (error:HttpErrorResponse)=>{
      console.log(error);
    }
  );

}

public preparedocumentData(document:Document):FormData{

  const formData = new FormData();
  formData.append('document', 
  new Blob([ JSON.stringify(document)],{type:'applicatio/json'}));

return formData;
}


newBooking(): void {
  this.submitted = false;
  this.document;
}

save() {
  this.documentService.add(this.document)
  .subscribe(data => console.log(data),
  error => console.log(error));
  this.document;
  //this.gotoList();
}

onSubmit() {
  this.submitted = true;
  this.save();
}

// gotoList() {
//   this.router.navigate(['/bookings']);
// }





  }


