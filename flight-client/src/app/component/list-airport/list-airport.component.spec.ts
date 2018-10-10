import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAirportComponent } from './list-airport.component';

describe('ListAirportComponent', () => {
  let component: ListAirportComponent;
  let fixture: ComponentFixture<ListAirportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListAirportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAirportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
