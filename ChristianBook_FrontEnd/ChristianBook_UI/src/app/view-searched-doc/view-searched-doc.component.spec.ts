import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSearchedDocComponent } from './view-searched-doc.component';

describe('ViewSearchedDocComponent', () => {
  let component: ViewSearchedDocComponent;
  let fixture: ComponentFixture<ViewSearchedDocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewSearchedDocComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewSearchedDocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
