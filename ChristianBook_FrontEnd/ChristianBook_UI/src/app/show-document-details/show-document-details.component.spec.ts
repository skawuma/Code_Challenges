import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowDocumentDetailsComponent } from './show-document-details.component';

describe('ShowDocumentDetailsComponent', () => {
  let component: ShowDocumentDetailsComponent;
  let fixture: ComponentFixture<ShowDocumentDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowDocumentDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowDocumentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
