import { TestBed } from '@angular/core/testing';

import { ProfileuserService } from './profileuser.service';

describe('ProfileuserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProfileuserService = TestBed.get(ProfileuserService);
    expect(service).toBeTruthy();
  });
});
