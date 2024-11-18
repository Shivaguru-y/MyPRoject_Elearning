import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CommonService } from '../../common.service';

@Component({
  selector: 'app-login-sign',
  templateUrl: './login-sign.component.html',
})
export class LoginOrSignComponent {
  activeTab = 'login';  // Default active tab is login
  loginForm: FormGroup;
  registerForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private commonService: CommonService
  ) {
    // Login form initialization
    this.loginForm = this.fb.group({
      email: ['', [Validators.required]],
      password: ['', Validators.required],
    });

    // Registration form initialization
    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      repeatPassword: ['', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
    });
  }

  setActiveTab(tab: string) {
    this.activeTab = tab;
    console.log(tab);
  }

  async onLoginSubmit() {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;
      try {
        this.commonService.Login(this.loginForm.value).subscribe((response: any) => {
          if (response.role === 'admin') {
            this.router.navigate(['/admin']);
          } else if (response.role === 'user') {
            this.router.navigate(['/course-section']);
          }
        })
      } catch (error) {
        console.error('Login failed:', error);
        alert('Invalid credentials!');
      }
    }
  }
  // async onRegisterSubmit() {
  //   console.log("Form Data:", this.registerForm.value);
  //   if (this.registerForm.valid) {
  //     const { name, email, password, repeatPassword } = this.registerForm.value;
  //     if (password !== repeatPassword) {
  //       alert('Passwords do not match!');
  //       return;
  //     }

  //     try {
  //       console.log(name, email, password);
  //       const regData= {email: email,name: name,password: password}

  //       await this.http
  //         .post('http://localhost:8080/auth/register', {regData},{ responseType: 'text' })
  //         .toPromise(
  //         );
  //       alert('Registration successful! You can now log in.');
  //       this.setActiveTab('login');
  //     } catch (error) {
  //       console.error('Registration failed:', error);
  //       alert('Registration failed!');
  //     }
  //   } else {
  //     alert('Please fill all required fields correctly!');
  //   }
  // }

  onRegisterSubmit() {

    if (this.registerForm.valid) {
      const { name, email, password, repeatPassword } = this.registerForm.value;
      if (password !== repeatPassword) {
        alert('Passwords do not match!');
        return;
      }


      console.log(name, email, password);
      const regData = { email: email, name: name, password: password }

      this.commonService.Register(regData).subscribe(data => {
        console.log("USER SAVED RESPONSE VALUE :::: " , data);

      })
    }
  }
}
