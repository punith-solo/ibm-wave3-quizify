import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileUserComponent } from './profileuser.component';

describe('ProfileUserComponent', () => {
  let component: ProfileUserComponent;
  let fixture: ComponentFixture<ProfileUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
