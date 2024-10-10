package be.vinci.domain;

class FilmImpl implements Film {

  private int id;
  private String title;
  private int duration;
  private long budget;
  private String link;

  public FilmImpl() {
  }

  public FilmImpl(int id, String title, int duration, long budget, String link) {
    this.id = id;
    this.title = title;
    this.duration = duration;
    this.budget = budget;
    this.link = link;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public int getDuration() {
    return duration;
  }

  @Override
  public void setDuration(int duration) {
    this.duration = duration;
  }

  @Override
  public long getBudget() {
    return budget;
  }

  @Override
  public void setBudget(long budget) {
    this.budget = budget;
  }

  @Override
  public String getLink() {
    return link;
  }

  @Override
  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public String toString() {
    return "Film [id=" + id + ", title=" + title + ", duration=" + duration + ", budget=" + budget + ", link="
        + link + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    FilmImpl film = (FilmImpl) o;

    return id == film.id;
  }

  @Override
  public int hashCode() {
    return id;
  }
}

