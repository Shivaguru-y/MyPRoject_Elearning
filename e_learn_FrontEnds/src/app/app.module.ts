import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './common/nav-bar/nav-bar.component';
import { CourseSectionComponent } from './components/course-section/course-section.component';
import { HeroComponent } from './common/hero/hero.component';
import { LoginOrSignComponent } from './components/login-sign/login-sign.component';
import { FooterComponent } from './common/footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FrontEndComponent } from './components/front-end/front-end.component';
import { MaterialsComponent } from './components/materials/materials.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    CourseSectionComponent,
    HeroComponent,
    LoginOrSignComponent,
    FooterComponent,
    FrontEndComponent,
    MaterialsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
