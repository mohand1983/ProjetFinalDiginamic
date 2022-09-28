export interface Filter<T> {
  subject: T;
  filters?: { [key: string]: any };
}
