import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicEventsTableComponent } from './public-events-table.component';

describe('PublicEventsTableComponent', () => {
  let component: PublicEventsTableComponent;
  let fixture: ComponentFixture<PublicEventsTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PublicEventsTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PublicEventsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
