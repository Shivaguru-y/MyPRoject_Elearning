import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { Apis } from './common/Endpoints';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private http: HttpClient) { }

  getAllStacks() {
    return this.http.get(environment.apiUrl + Apis.STACKS.GET_ALL_STACKS);
  }
  Login(formData:any) {
    return this.http.post(environment.apiUrl + Apis.Auth.LOGIN, formData);
  }
  Register(formData: any) {
    return this.http.post(environment.apiUrl + Apis.Auth.REGISTER, formData);
  }

  getCoursesByStack(stackId: number) {
    return this.http.get(environment.apiUrl + Apis.COURSE.GET_COURSE_BY_STACK_ID+stackId);
  }

}
