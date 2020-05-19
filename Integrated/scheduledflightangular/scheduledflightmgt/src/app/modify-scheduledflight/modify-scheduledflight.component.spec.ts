import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyScheduledflightComponent } from './modify-scheduledflight.component';

describe('ModifyScheduledflightComponent', () => {
  let component: ModifyScheduledflightComponent;
  let fixture: ComponentFixture<ModifyScheduledflightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyScheduledflightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyScheduledflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
