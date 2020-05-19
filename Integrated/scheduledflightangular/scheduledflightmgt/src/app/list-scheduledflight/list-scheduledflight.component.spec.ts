import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListScheduledflightComponent } from './list-scheduledflight.component';

describe('ListScheduledflightComponent', () => {
  let component: ListScheduledflightComponent;
  let fixture: ComponentFixture<ListScheduledflightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListScheduledflightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListScheduledflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
