import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddScheduledflightComponent } from './add-scheduledflight.component';

describe('AddScheduledflightComponent', () => {
  let component: AddScheduledflightComponent;
  let fixture: ComponentFixture<AddScheduledflightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddScheduledflightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddScheduledflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
