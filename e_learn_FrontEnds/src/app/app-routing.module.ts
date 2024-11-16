import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseSectionComponent } from './components/course-section/course-section.component';
import { LoginOrSignComponent } from './components/login-sign/login-sign.component';
import { FrontEndComponent } from './components/front-end/front-end.component';

const routes: Routes = [
  {
    path:"course-section",
    component:CourseSectionComponent
  },
  {
    path:'',
    component:LoginOrSignComponent
  },
  {
    path:"Front-End/:stackId",
    component:FrontEndComponent
  },
  {
    path: '**',
    redirectTo: ''
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
