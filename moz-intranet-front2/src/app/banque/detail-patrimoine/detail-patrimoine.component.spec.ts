import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailPatrimoineComponent } from './detail-patrimoine.component';

describe('DetailPatrimoineComponent', () => {
  let component: DetailPatrimoineComponent;
  let fixture: ComponentFixture<DetailPatrimoineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailPatrimoineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailPatrimoineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
