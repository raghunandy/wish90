/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package leona.gygafun.wish90.domain;

import java.util.Date;
import java.util.List;

/**
 * Class that represents a User in the domain layer.
 */
public class UserMoment{

  private String momentId;


  private Date momentDateTime;


  private String title;

  private String type;


  private List<String> tags;

  private String userId;


  private String configurations;



  public String getMomentId() {
    return momentId;
  }

  public void setMomentId(String momentId) {
    this.momentId = momentId;
  }

  public Date getMomentDateTime() {
    return momentDateTime;
  }

  public void setMomentDateTime(Date momentDateTime) {
    this.momentDateTime = momentDateTime;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getConfigurations() {
    return configurations;
  }

  public void setConfigurations(String configurations) {
    this.configurations = configurations;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
