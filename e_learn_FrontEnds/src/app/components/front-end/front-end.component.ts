import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-front-end',
  templateUrl: './front-end.component.html',
  styleUrls: ['./front-end.component.css']
})
export class FrontEndComponent implements OnInit {
  stackId: any;
  courses : any;
  error: string | null = null;

  constructor(private route: ActivatedRoute,private http: HttpClient) {}

  ngOnInit(): void {

    this.route.paramMap.subscribe(params => {
      this.stackId = params.get('stackId');
      console.log('Stack ID:', this.stackId);
      this.getCoursesByStack(this.stackId);

    });
  }
  getCoursesByStack(stackId: number):void{
    this.http.get(`http://localhost:8080/courses/getCoursebyStack/${stackId}`).subscribe(
      (response: any) => {
        this.courses = response;
        console.log(this.courses);
      },
      (error) => {
        console.error('Error fetching courses by stack:', error);
        this.error = 'Failed to load courses. Please try again later.';
      }
    );

  }
  shareCourse(): void {
    const courseLink = "https://www.youtube.com/watch?v=x-lStpKfqHo"
    if (navigator.share) {
      navigator.share({
        title: 'Check out this course!',
        url: courseLink
      }).then(() => {
        console.log('Course shared successfully');
      }).catch((error) => {
        console.error('Error sharing:', error);
      });
    } else {

      this.copyToClipboard(courseLink);
    }
  }


  copyToClipboard(courseLink: string): void {
    const textarea = document.createElement('textarea');
    textarea.value = courseLink;
    document.body.appendChild(textarea);
    textarea.select();
    document.execCommand('copy');
    document.body.removeChild(textarea);
    alert('Course link copied to clipboard!');
  }

}
