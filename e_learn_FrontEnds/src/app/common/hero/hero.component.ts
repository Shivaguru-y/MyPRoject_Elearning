import { Component, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { isPlatformBrowser } from '@angular/common';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {
  currentPath: string = '';

  constructor(@Inject(PLATFORM_ID) private platformId: Object, private router: Router) {}

  ngOnInit(): void {
    if (isPlatformBrowser(this.platformId)) {
      // Subscribe to Router events to track path changes
      this.router.events.pipe(filter(event => event instanceof NavigationEnd)).subscribe(() => {
        this.currentPath = this.router.url;
        console.log(this.currentPath);
      });

      // Initialize AOS (Animate On Scroll) only in the browser
      import('aos').then(AOS => {
        AOS.init();
      });
    }
  }
}
