import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Document } from '../_model/document.model';
;


@Component({
  selector: 'app-view-searched-doc',
  templateUrl: './view-searched-doc.component.html',
  styleUrls: ['./view-searched-doc.component.css']
})
export class ViewSearchedDocComponent implements OnInit {
  isNewProduct= true;
   documentDetails: Document[] = [{
    sku:'sku',
    author:'author',
    title:'title',
    price:0
  }

   ];
   
  

  document:Document={
    sku: '',
    author: '',
    title: '',
    price: 0
  }
  // documentDetails: Document[]=[];

  constructor(private activatedRoute: ActivatedRoute,) { }
  displayedColumns: string[] = ['SKU', 'Author','Title','Price']
  ngOnInit(): void {
 


    console.log(
      'Activated route data in Component:::',
      this.activatedRoute.data
    );
    this.activatedRoute.data.subscribe((response: any) => {
      console.log('PRODUCT FETCHING', response);
     
      this.document = response.document;
      
      console.log('PRODUCT FETCHED');
     
      
      console.log(response);

  
    });
  

// this.documentDetails = this.activatedRoute.snapshot.data['documentDetails'];
    
console.log(this.documentDetails);
console.log(this.document);


    
  }
  

}
