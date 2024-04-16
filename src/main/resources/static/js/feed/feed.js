const feedUrl = /*[[${urls.FEED_URI}]]*/ "";
let postStr = '';
let dateString = null;

$.ajax({
    url: feedUrl,
    method: 'POST',
    contentType: 'application/json',
    success: function(response) {
        renderFeedList(response, dateString);
    },
    error: function (err) {
        alert('피드 리스트 조회 실패');
    }
});

function renderFeedList(response, dateString) {

    for(var i = 0; i < response.data.length; i++) {
        dateString = new Date(response.data[i].regist_date);

        postStr += `
                    <div class="card is-post">
                      <div class="content-wrap">
                        <div class="card-heading">
                          <div class="user-block">
                            <div class="image">
                              <img src="https://via.placeholder.com/300x300" data-demo-src="/img/avatars/edward.jpeg" data-user-popover="5" alt=""/>
                            </div>
                            <div class="user-info">
                              <a href="#">${response.data[i].member_id}</a>
                              <span class="time">${dateString.toLocaleDateString()}</span>
                            </div>
                          </div>
                    
                          <div class="dropdown is-spaced is-right is-neutral dropdown-trigger">
                            <div>
                              <div class="button">
                                <i data-feather="more-vertical"></i>
                              </div>
                            </div>
                            <div class="dropdown-menu" role="menu">
                              <div class="dropdown-content">
                                <a href="#" class="dropdown-item">
                                  <div class="media">
                                    <i data-feather="bookmark"></i>
                                    <div class="media-content">
                                      <h3>Bookmark</h3>
                                      <small>Add this post to your bookmarks.</small>
                                    </div>
                                  </div>
                                </a>
                                <a class="dropdown-item">
                                  <div class="media">
                                    <i data-feather="bell"></i>
                                    <div class="media-content">
                                      <h3>Notify me</h3>
                                      <small>Send me the updates.</small>
                                    </div>
                                  </div>
                                </a>
                                <hr class="dropdown-divider" />
                                <a href="#" class="dropdown-item">
                                  <div class="media">
                                    <i data-feather="flag"></i>
                                    <div class="media-content">
                                      <h3>Flag</h3>
                                      <small>In case of inappropriate content.</small>
                                    </div>
                                  </div>
                                </a>
                              </div>
                            </div>
                          </div>
                    
                        </div>
                    
                        <div class="card-body">
                          <div class="post-text">
                            <p>
                              ${response.data[i].content}
                            </p>
                    
                            <p></p>
                          </div>
                          <div class="post-link is-video">
                            <div class="link-image">
                              <img src="https://via.placeholder.com/300x300" data-demo-src="/img/demo/video/bootstrap.jpg" alt=""/>
                              <div class="video-overlay"></div>
                              <a class="video-button" data-fancybox href="https://www.youtube.com/watch?v=N8GksI_-iIM">
                                <img src="/img/icons/video/play.svg" alt="" />
                              </a>
                            </div>
                            <div class="link-content">
                              <h4>
                                <a href="#">What's new in Bootstrap 4 ?</a>
                              </h4>
                              <p>
                                Before I create the new Bootstrap 4 crash course I want to go over
                                some of the changes from Bootstrap 3.
                              </p>
                              <small>Youtube.com</small>
                            </div>
                    
                            <div class="like-wrapper">
                              <a href="javascript:void(0);" class="like-button">
                                <i class="mdi mdi-heart not-liked bouncy"></i>
                                <i class="mdi mdi-heart is-liked bouncy"></i>
                                <span class="like-overlay"></span>
                              </a>
                            </div>
                    
                            <div class="fab-wrapper is-share">
                              <a href="javascript:void(0);" class="small-fab share-fab modal-trigger" data-modal="share-modal">
                                <i data-feather="link-2"></i>
                              </a>
                            </div>
                    
                            <div class="fab-wrapper is-comment">
                              <a href="javascript:void(0);" class="small-fab">
                                <i data-feather="message-circle"></i>
                              </a>
                            </div>
                          </div>
                        </div>
                    
                        <div class="card-footer">
                          <div class="likers-group">
                            <img src="https://via.placeholder.com/300x300" data-demo-src="/img/avatars/daniel.jpg" data-user-popover="3" alt=""/>
                            <img src="https://via.placeholder.com/300x300" data-demo-src="/img/avatars/elise.jpg" data-user-popover="6" alt=""/>
                          </div>
                          <div class="likers-text">
                            <p>
                              <a href="#">Daniel</a> and
                              <a href="#">Elise</a>
                            </p>
                            <p>liked this</p>
                          </div>
                          <div class="social-count">
                            <div class="likes-count">
                              <i data-feather="heart"></i>
                              <span>2</span>
                            </div>
                            <div class="shares-count">
                              <i data-feather="link-2"></i>
                              <span>0</span>
                            </div>
                            <div class="comments-count">
                              <i data-feather="message-circle"></i>
                              <span>2</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    
                      <div class="comments-wrap is-hidden">
                        <div class="comments-heading">
                          <h4>Comments <small>(2)</small></h4>
                          <div class="close-comments">
                            <i data-feather="x"></i>
                          </div>
                        </div>
                    
                        <div class="comments-body has-slimscroll">
                          <div class="media is-comment">
                            <div class="media-left">
                              <div class="image">
                                <img src="https://via.placeholder.com/300x300" data-demo-src="/img/avatars/elise.jpg" data-user-popover="6" alt=""/>
                              </div>
                            </div>
                            <div class="media-content">
                              <a href="#">Elise Walker</a>
                              <span class="time">2 days ago</span>
                              <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                                eiusmod tempo incididunt ut labore et dolore magna aliqua. Ut enim
                                ad minim veniam, quis nostrud exercitation ullamco laboris
                                consequat.
                              </p>
                              <div class="controls">
                                <div class="like-count">
                                  <i data-feather="thumbs-up"></i>
                                  <span>1</span>
                                </div>
                                <div class="reply">
                                  <a href="#">Reply</a>
                                </div>
                              </div>
                    
                              <div class="media is-comment">
                                <div class="media-left">
                                  <div class="image">
                                    <img src="https://via.placeholder.com/300x300" data-demo-src="/img/avatars/daniel.jpg" data-user-popover="3" alt=""/>
                                  </div>
                                </div>
                                <div class="media-content">
                                  <a href="#">Daniel Wellington</a>
                                  <span class="time">2 days ago</span>
                                  <p>
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                                    eiusmod tempo incididunt ut labore et dolore magna aliqua.
                                  </p>
                                  <div class="controls">
                                    <div class="like-count">
                                      <i data-feather="thumbs-up"></i>
                                      <span>0</span>
                                    </div>
                                    <div class="reply">
                                      <a href="#">Reply</a>
                                    </div>
                                  </div>
                                </div>
                    
                                <div class="media-right">
                                  <div class="dropdown is-spaced is-right is-neutral dropdown-trigger">
                                    <div>
                                      <div class="button">
                                        <i data-feather="more-vertical"></i>
                                      </div>
                                    </div>
                                    <div class="dropdown-menu" role="menu">
                                      <div class="dropdown-content">
                                        <a class="dropdown-item">
                                          <div class="media">
                                            <i data-feather="x"></i>
                                            <div class="media-content">
                                              <h3>Hide</h3>
                                              <small>Hide this comment.</small>
                                            </div>
                                          </div>
                                        </a>
                                        <div class="dropdown-divider"></div>
                                        <a href="#" class="dropdown-item">
                                          <div class="media">
                                            <i data-feather="flag"></i>
                                            <div class="media-content">
                                              <h3>Report</h3>
                                              <small>Report this comment.</small>
                                            </div>
                                          </div>
                                        </a>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                    
                            <div class="media-right">
                              <div class="dropdown is-spaced is-right is-neutral dropdown-trigger">
                                <div>
                                  <div class="button">
                                    <i data-feather="more-vertical"></i>
                                  </div>
                                </div>
                                <div class="dropdown-menu" role="menu">
                                  <div class="dropdown-content">
                                    <a class="dropdown-item">
                                      <div class="media">
                                        <i data-feather="x"></i>
                                        <div class="media-content">
                                          <h3>Hide</h3>
                                          <small>Hide this comment.</small>
                                        </div>
                                      </div>
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a href="#" class="dropdown-item">
                                      <div class="media">
                                        <i data-feather="flag"></i>
                                        <div class="media-content">
                                          <h3>Report</h3>
                                          <small>Report this comment.</small>
                                        </div>
                                      </div>
                                    </a>
                                  </div>
                                </div>
                              </div>
                            </div>
                    
                          </div>
                        </div>
                    
                        <div class="card-footer">
                          <div class="media post-comment has-emojis">
                            <div class="media-content">
                              <div class="field">
                                <p class="control">
                                  <textarea
                                    class="textarea comment-textarea"
                                    rows="5"
                                    placeholder="Write a comment..."
                                  ></textarea>
                                </p>
                              </div>
                              <div class="actions">
                                <div class="image is-32x32">
                                  <img class="is-rounded" src="https://via.placeholder.com/300x300" data-demo-src="/img/avatars/jenna.png" data-user-popover="0" alt=""/>
                                </div>
                                <div class="toolbar">
                                  <div class="action is-auto">
                                    <i data-feather="at-sign"></i>
                                  </div>
                                  <div class="action is-emoji">
                                    <i data-feather="smile"></i>
                                  </div>
                                  <div class="action is-upload">
                                    <i data-feather="camera"></i>
                                    <input type="file" />
                                  </div>
                                  <a class="button is-solid primary-button raised">Post Comment</a>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>`;

    }

    postStr += `
                <div class="load-more-wrap narrow-top has-text-centered">
                    <a href="#" class="load-more-button">Load More</a>
                </div>
               `;
                

    $('.column.is-6').append(postStr);

}

function formatDate(dateStr) {

    let date = new Date(dateStr);
    let year = date.getFullYear();
    let month = ('0' + (date.getMonth() + 1)).slice(-2);
    let day = ('0' + date.getDate()).slice(-2);
    let hours = ('0' + date.getHours()).slice(-2);
    let minutes = ('0' + date.getMinutes()).slice(-2);
    let seconds = ('0' + date.getSeconds()).slice(-2);

    return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;

}

