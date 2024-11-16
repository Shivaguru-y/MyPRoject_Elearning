import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonService } from '../../common.service';

@Component({
  selector: 'app-course-section',
  templateUrl: './course-section.component.html',
  styleUrls: ['./course-section.component.css']
})
export class CourseSectionComponent implements OnInit {
  stacks: any[] = [];
  error: string | null = null;

  constructor(private http: HttpClient,private router:Router,private commonService: CommonService) {}

  ngOnInit(): void {
    this.fetchStacks();
  }

  selectStack(stacks:any){
    console.log("This the selected Stacks",stacks);
    this.router.navigate(['/Front-End', stacks.stackId]);


  }

  fetchStacks(): void {
    this.commonService.getAllStacks().subscribe(
      (response: any) => {
        this.stacks = response;
        console.log(this.stacks);
      },
      (error) => {
        console.error('Error fetching stacks:', error);
        this.error = 'Failed to load stacks. Please try again later.';
      }
    );
  }
}
