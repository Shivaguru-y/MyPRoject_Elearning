import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';  // Import necessary classes

@Component({
  selector: 'app-materials',
  templateUrl: './materials.component.html',
  styleUrls: ['./materials.component.css']  
})
export class MaterialsComponent implements OnInit {

  courseId: any;
  materials: any;
  error: any;

  constructor(
    private Route: ActivatedRoute,
    private http: HttpClient,
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit(): void {
    this.Route.paramMap.subscribe(params => {
      this.courseId = params.get('courseId');
      console.log('Course ID:', this.courseId);
      this.getMaterialsByCourse(this.courseId);
    });
  }

  getMaterialsByCourse(stackId: number): void {
    this.http.get(`http://localhost:8080/materials/getMaterialsByCourseId/${stackId}`).subscribe(
      (response: any) => {
        this.materials = response;
        console.log("Materials data:", this.materials);
      },
      (error) => {
        console.error('Error fetching materials:', error);
        this.error = 'Failed to load materials. Please try again later.';
      }
    );
  }

  sanitizeUrl(url: string): SafeResourceUrl {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
}
